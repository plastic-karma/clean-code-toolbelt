package de.plastickarma.cleancodetoolbelt.java

import spoon.reflect.code.CtAnnotationFieldAccess
import spoon.reflect.code.CtArrayRead
import spoon.reflect.code.CtArrayWrite
import spoon.reflect.code.CtAssert
import spoon.reflect.code.CtAssignment
import spoon.reflect.code.CtBinaryOperator
import spoon.reflect.code.CtBlock
import spoon.reflect.code.CtBreak
import spoon.reflect.code.CtCase
import spoon.reflect.code.CtCatch
import spoon.reflect.code.CtCatchVariable
import spoon.reflect.code.CtCodeSnippetExpression
import spoon.reflect.code.CtCodeSnippetStatement
import spoon.reflect.code.CtComment
import spoon.reflect.code.CtConditional
import spoon.reflect.code.CtConstructorCall
import spoon.reflect.code.CtContinue
import spoon.reflect.code.CtDo
import spoon.reflect.code.CtExecutableReferenceExpression
import spoon.reflect.code.CtExpression
import spoon.reflect.code.CtFieldRead
import spoon.reflect.code.CtFieldWrite
import spoon.reflect.code.CtFor
import spoon.reflect.code.CtForEach
import spoon.reflect.code.CtIf
import spoon.reflect.code.CtInvocation
import spoon.reflect.code.CtJavaDoc
import spoon.reflect.code.CtJavaDocTag
import spoon.reflect.code.CtLambda
import spoon.reflect.code.CtLiteral
import spoon.reflect.code.CtLocalVariable
import spoon.reflect.code.CtNewArray
import spoon.reflect.code.CtNewClass
import spoon.reflect.code.CtOperatorAssignment
import spoon.reflect.code.CtReturn
import spoon.reflect.code.CtStatementList
import spoon.reflect.code.CtSuperAccess
import spoon.reflect.code.CtSwitch
import spoon.reflect.code.CtSwitchExpression
import spoon.reflect.code.CtSynchronized
import spoon.reflect.code.CtTextBlock
import spoon.reflect.code.CtThisAccess
import spoon.reflect.code.CtThrow
import spoon.reflect.code.CtTry
import spoon.reflect.code.CtTryWithResource
import spoon.reflect.code.CtTypeAccess
import spoon.reflect.code.CtTypePattern
import spoon.reflect.code.CtUnaryOperator
import spoon.reflect.code.CtVariableRead
import spoon.reflect.code.CtVariableWrite
import spoon.reflect.code.CtWhile
import spoon.reflect.code.CtYieldStatement
import spoon.reflect.declaration.CtAnnotation
import spoon.reflect.declaration.CtAnnotationMethod
import spoon.reflect.declaration.CtAnnotationType
import spoon.reflect.declaration.CtAnonymousExecutable
import spoon.reflect.declaration.CtClass
import spoon.reflect.declaration.CtCompilationUnit
import spoon.reflect.declaration.CtConstructor
import spoon.reflect.declaration.CtEnum
import spoon.reflect.declaration.CtEnumValue
import spoon.reflect.declaration.CtField
import spoon.reflect.declaration.CtImport
import spoon.reflect.declaration.CtInterface
import spoon.reflect.declaration.CtMethod
import spoon.reflect.declaration.CtModule
import spoon.reflect.declaration.CtModuleRequirement
import spoon.reflect.declaration.CtPackage
import spoon.reflect.declaration.CtPackageDeclaration
import spoon.reflect.declaration.CtPackageExport
import spoon.reflect.declaration.CtParameter
import spoon.reflect.declaration.CtProvidedService
import spoon.reflect.declaration.CtRecord
import spoon.reflect.declaration.CtRecordComponent
import spoon.reflect.declaration.CtTypeParameter
import spoon.reflect.declaration.CtUsedService
import spoon.reflect.reference.CtArrayTypeReference
import spoon.reflect.reference.CtCatchVariableReference
import spoon.reflect.reference.CtExecutableReference
import spoon.reflect.reference.CtFieldReference
import spoon.reflect.reference.CtIntersectionTypeReference
import spoon.reflect.reference.CtLocalVariableReference
import spoon.reflect.reference.CtModuleReference
import spoon.reflect.reference.CtPackageReference
import spoon.reflect.reference.CtParameterReference
import spoon.reflect.reference.CtTypeMemberWildcardImportReference
import spoon.reflect.reference.CtTypeParameterReference
import spoon.reflect.reference.CtTypeReference
import spoon.reflect.reference.CtUnboundVariableReference
import spoon.reflect.reference.CtWildcardReference
import spoon.reflect.visitor.CtVisitor

open class DefaultVisitor : CtVisitor {
    override fun <A : Annotation?> visitCtAnnotation(annotation: CtAnnotation<A>) {
    }

    override fun <T : Any?> visitCtCodeSnippetExpression(expression: CtCodeSnippetExpression<T>) {
    }

    override fun visitCtCodeSnippetStatement(statement: CtCodeSnippetStatement) {
    }

    override fun <A : Annotation?> visitCtAnnotationType(annotationType: CtAnnotationType<A>) {
    }

    override fun visitCtAnonymousExecutable(anonymousExec: CtAnonymousExecutable) {
    }

    override fun <T : Any?> visitCtArrayRead(arrayRead: CtArrayRead<T>) {
    }

    override fun <T : Any?> visitCtArrayWrite(arrayWrite: CtArrayWrite<T>) {
    }

    override fun <T : Any?> visitCtArrayTypeReference(reference: CtArrayTypeReference<T>) {
    }

    override fun <T : Any?> visitCtAssert(asserted: CtAssert<T>) {
    }

    override fun <T : Any?, A : T> visitCtAssignment(assignement: CtAssignment<T, A>) {
    }

    override fun <T : Any?> visitCtBinaryOperator(operator: CtBinaryOperator<T>) {
    }

    override fun <R : Any?> visitCtBlock(block: CtBlock<R>) {
    }

    override fun visitCtBreak(breakStatement: CtBreak) {
    }

    override fun <S : Any?> visitCtCase(caseStatement: CtCase<S>) {
    }

    override fun visitCtCatch(catchBlock: CtCatch) {
    }

    override fun <T : Any?> visitCtClass(ctClass: CtClass<T>) {
    }

    override fun visitCtTypeParameter(typeParameter: CtTypeParameter) {
    }

    override fun <T : Any?> visitCtConditional(conditional: CtConditional<T>) {
    }

    override fun <T : Any?> visitCtConstructor(c: CtConstructor<T>) {
    }

    override fun visitCtContinue(continueStatement: CtContinue) {
    }

    override fun visitCtDo(doLoop: CtDo) {
    }

    override fun <T : Enum<*>?> visitCtEnum(ctEnum: CtEnum<T>) {
    }

    override fun <T : Any?> visitCtExecutableReference(reference: CtExecutableReference<T>) {
    }

    override fun <T : Any?> visitCtField(f: CtField<T>) {
    }

    override fun <T : Any?> visitCtEnumValue(enumValue: CtEnumValue<T>) {
    }

    override fun <T : Any?> visitCtThisAccess(thisAccess: CtThisAccess<T>) {
    }

    override fun <T : Any?> visitCtFieldReference(reference: CtFieldReference<T>) {
    }

    override fun <T : Any?> visitCtUnboundVariableReference(reference: CtUnboundVariableReference<T>) {
    }

    override fun visitCtFor(forLoop: CtFor) {
    }

    override fun visitCtForEach(foreach: CtForEach) {
    }

    override fun visitCtIf(ifElement: CtIf) {
    }

    override fun <T : Any?> visitCtInterface(intrface: CtInterface<T>) {
    }

    override fun <T : Any?> visitCtInvocation(invocation: CtInvocation<T>) {
    }

    override fun <T : Any?> visitCtLiteral(literal: CtLiteral<T>) {
    }

    override fun visitCtTextBlock(ctTextBlock: CtTextBlock) {
    }

    override fun <T : Any?> visitCtLocalVariable(localVariable: CtLocalVariable<T>) {
    }

    override fun <T : Any?> visitCtLocalVariableReference(reference: CtLocalVariableReference<T>) {
    }

    override fun <T : Any?> visitCtCatchVariable(catchVariable: CtCatchVariable<T>) {
    }

    override fun <T : Any?> visitCtCatchVariableReference(reference: CtCatchVariableReference<T>) {
    }

    override fun <T : Any?> visitCtMethod(m: CtMethod<T>) {
    }

    override fun <T : Any?> visitCtAnnotationMethod(annotationMethod: CtAnnotationMethod<T>) {
    }

    override fun <T : Any?> visitCtNewArray(newArray: CtNewArray<T>) {
    }

    override fun <T : Any?> visitCtConstructorCall(ctConstructorCall: CtConstructorCall<T>) {
    }

    override fun <T : Any?> visitCtNewClass(newClass: CtNewClass<T>) {
    }

    override fun <T : Any?> visitCtLambda(lambda: CtLambda<T>) {
    }

    override fun <T : Any?, E : CtExpression<*>?> visitCtExecutableReferenceExpression(expression: CtExecutableReferenceExpression<T, E>) {
    }

    override fun <T : Any?, A : T> visitCtOperatorAssignment(assignment: CtOperatorAssignment<T, A>) {
    }

    override fun visitCtPackage(ctPackage: CtPackage) {
    }

    override fun visitCtPackageReference(reference: CtPackageReference) {
    }

    override fun <T : Any?> visitCtParameter(parameter: CtParameter<T>) {
    }

    override fun <T : Any?> visitCtParameterReference(reference: CtParameterReference<T>) {
    }

    override fun <R : Any?> visitCtReturn(returnStatement: CtReturn<R>) {
    }

    override fun <R : Any?> visitCtStatementList(statements: CtStatementList) {
    }

    override fun <S : Any?> visitCtSwitch(switchStatement: CtSwitch<S>) {
    }

    override fun <T : Any?, S : Any?> visitCtSwitchExpression(switchExpression: CtSwitchExpression<T, S>) {
    }

    override fun visitCtSynchronized(synchro: CtSynchronized) {
    }

    override fun visitCtThrow(throwStatement: CtThrow) {
    }

    override fun visitCtTry(tryBlock: CtTry) {
    }

    override fun visitCtTryWithResource(tryWithResource: CtTryWithResource) {
    }

    override fun visitCtTypeParameterReference(ref: CtTypeParameterReference) {
    }

    override fun visitCtWildcardReference(wildcardReference: CtWildcardReference) {
    }

    override fun <T : Any?> visitCtIntersectionTypeReference(reference: CtIntersectionTypeReference<T>) {
    }

    override fun <T : Any?> visitCtTypeReference(reference: CtTypeReference<T>) {
    }

    override fun <T : Any?> visitCtTypeAccess(typeAccess: CtTypeAccess<T>) {
    }

    override fun <T : Any?> visitCtUnaryOperator(operator: CtUnaryOperator<T>) {
    }

    override fun <T : Any?> visitCtVariableRead(variableRead: CtVariableRead<T>) {
    }

    override fun <T : Any?> visitCtVariableWrite(variableWrite: CtVariableWrite<T>) {
    }

    override fun visitCtWhile(whileLoop: CtWhile) {
    }

    override fun <T : Any?> visitCtAnnotationFieldAccess(annotationFieldAccess: CtAnnotationFieldAccess<T>) {
    }

    override fun <T : Any?> visitCtFieldRead(fieldRead: CtFieldRead<T>) {
    }

    override fun <T : Any?> visitCtFieldWrite(fieldWrite: CtFieldWrite<T>) {
    }

    override fun <T : Any?> visitCtSuperAccess(f: CtSuperAccess<T>) {
    }

    override fun visitCtComment(comment: CtComment) {
    }

    override fun visitCtJavaDoc(comment: CtJavaDoc) {
    }

    override fun visitCtJavaDocTag(docTag: CtJavaDocTag) {
    }

    override fun visitCtImport(ctImport: CtImport) {
    }

    override fun visitCtModule(module: CtModule) {
    }

    override fun visitCtModuleReference(moduleReference: CtModuleReference) {
    }

    override fun visitCtPackageExport(moduleExport: CtPackageExport) {
    }

    override fun visitCtModuleRequirement(moduleRequirement: CtModuleRequirement) {
    }

    override fun visitCtProvidedService(moduleProvidedService: CtProvidedService) {
    }

    override fun visitCtUsedService(usedService: CtUsedService) {
    }

    override fun visitCtCompilationUnit(compilationUnit: CtCompilationUnit) {
    }

    override fun visitCtPackageDeclaration(packageDeclaration: CtPackageDeclaration) {
    }

    override fun visitCtTypeMemberWildcardImportReference(wildcardReference: CtTypeMemberWildcardImportReference) {
    }

    override fun visitCtYieldStatement(statement: CtYieldStatement) {
    }

    override fun visitCtTypePattern(pattern: CtTypePattern) {
    }

    override fun visitCtRecord(recordType: CtRecord) {
    }

    override fun visitCtRecordComponent(recordComponent: CtRecordComponent) {
    }
}
