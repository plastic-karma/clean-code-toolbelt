package de.plastickarma.cleancodetoolbelt.java.npath

import de.plastickarma.cleancodetoolbelt.java.DefaultVisitor
import spoon.reflect.CtModel
import spoon.reflect.code.BinaryOperatorKind
import spoon.reflect.code.CtBinaryOperator
import spoon.reflect.code.CtBlock
import spoon.reflect.code.CtConditional
import spoon.reflect.code.CtDo
import spoon.reflect.code.CtExpression
import spoon.reflect.code.CtFor
import spoon.reflect.code.CtForEach
import spoon.reflect.code.CtIf
import spoon.reflect.code.CtReturn
import spoon.reflect.code.CtStatement
import spoon.reflect.code.CtSwitch
import spoon.reflect.code.CtWhile
import spoon.reflect.declaration.CtElement
import spoon.reflect.declaration.CtMethod

fun npath(model: CtModel): List<Pair<CtMethod<*>, Int>> {
    return model.allTypes
        .flatMap { it.allMethods }
        .filter { it.declaringType.simpleName != "Object" }
        .filter { !it.isAbstract }
        .map { method ->
            val npathValue = npath(method.body, { })
            method to npathValue
        }
}

fun npath(element: CtElement, debugLogger: (String) -> Unit): Int {
    return NpathCounter(debugLogger).also { element.accept(it) }.npathValue
}

private class NpathCounter(private val debugLogger: (String) -> Unit) : DefaultVisitor() {
    var npathValue = 1
        private set

    override fun visitCtIf(ifElement: CtIf) = withPositionLogging(ifElement) {
        npathValue = 1 +
            countBinaryOps(ifElement.condition) +
            npath(ifElement.getThenStatement(), debugLogger) +
            (ifElement.getElseStatement<CtStatement>()?.let { npath(it, debugLogger) } ?: 0)
    }

    override fun visitCtWhile(whileLoop: CtWhile) = withPositionLogging(whileLoop) {
        npathValue = 1 +
            npath(whileLoop.loopingExpression, debugLogger) +
            npath(whileLoop.body, debugLogger)
    }

    override fun visitCtDo(doLoop: CtDo) = withPositionLogging(doLoop) {
        npathValue = 1 +
            npath(doLoop.loopingExpression, debugLogger) +
            npath(doLoop.body, debugLogger)
    }

    override fun visitCtFor(forLoop: CtFor) = withPositionLogging(forLoop) {
        npathValue = 1 +
            npath(forLoop.body, debugLogger) +
            forLoop.forInit.sumOf { npath(it, debugLogger) } +
            forLoop.forUpdate.sumOf { npath(it, debugLogger) } +
            countBinaryOps(forLoop.expression)
    }

    override fun visitCtForEach(foreach: CtForEach) = withPositionLogging(foreach) {
        npathValue =
            npath(foreach.body, debugLogger) +
                countBinaryOps(foreach.expression)
    }

    override fun <S> visitCtSwitch(switchStatement: CtSwitch<S>) = withPositionLogging(switchStatement) {
        npathValue =
            npath(switchStatement.selector, debugLogger) +
                switchStatement.cases.flatMap { it.statements }.sumOf { npath(it, debugLogger) }
    }

    override fun <R> visitCtBlock(block: CtBlock<R>) = withPositionLogging(block) {
        npathValue = block.directChildren.map { element ->
            val npathValue = npath(element, debugLogger)
            debugLogger("Block component ${element.javaClass.simpleName} at ${element.position} Npath value: $npathValue")
            npathValue
        }.reduce { acc: Int, i: Int -> acc * i }
    }

    override fun <T> visitCtBinaryOperator(operator: CtBinaryOperator<T>) = withPositionLogging(operator) {
        npathValue = countBinaryOps(operator)
    }

    override fun <T> visitCtConditional(conditional: CtConditional<T>) = withPositionLogging(conditional) {
        npathValue = 2 + countBinaryOps(conditional.condition) + countBinaryOps(conditional.elseExpression) + countBinaryOps(conditional.thenExpression)
    }

    override fun <R> visitCtReturn(returnStatement: CtReturn<R>) = withPositionLogging(returnStatement) {
        npathValue = 1 + (returnStatement.returnedExpression?.let { npath(it, debugLogger) } ?: 0)
    }

    private fun withPositionLogging(element: CtElement, block: () -> Unit) {
        debugLogger("Entering ${element.javaClass.simpleName} at ${element.position}. Current value $npathValue")
        block()
        debugLogger("Leaving ${element.javaClass.simpleName} at ${element.position}. Current value $npathValue")
    }

    private fun countBinaryOps(element: CtExpression<*>): Int {
        var count = 0
        element.accept(object : DefaultVisitor() {
            override fun <T> visitCtBinaryOperator(operator: CtBinaryOperator<T>) {
                if (operator.kind == BinaryOperatorKind.AND || operator.kind == BinaryOperatorKind.OR) {
                    count = 1
                }
                count += countBinaryOps(operator.leftHandOperand) + countBinaryOps(operator.rightHandOperand)
            }
        })
        return count
    }
}
