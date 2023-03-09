package de.plastickarma.cleancodetoolbelt.java.npath

import de.plastickarma.cleancodetoolbelt.java.getByName
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import spoon.Launcher
import spoon.reflect.declaration.CtMethod

class NpathWhileConstructsTest : StringSpec({

    lateinit var npathValues: List<Pair<CtMethod<*>, Int>>

    beforeTest {
        val spoon = Launcher()
        spoon.factory.environment.apply {
            isIgnoreDuplicateDeclarations = true
            ignoreSyntaxErrors = true
        }
        spoon.addInputResource(NpathWhileConstructsTest::class.java.getResource("/WhileTests.java").file)
        spoon.buildModel()
        npathValues = npath(spoon.model)
    }

    "whileTest1" { npathValues.getByName("whileTest1") shouldBe 2 }
    "whileTest2" { npathValues.getByName("whileTest2") shouldBe 3 }
    "whileAndIf" { npathValues.getByName("whileAndIf") shouldBe 5 }
})
