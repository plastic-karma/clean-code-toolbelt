package de.plastickarma.cleancodetoolbelt.java.npath

import de.plastickarma.cleancodetoolbelt.java.getByName
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import spoon.Launcher
import spoon.reflect.declaration.CtMethod

class NpathDoConstructsTest : StringSpec({

    lateinit var npathValues: List<Pair<CtMethod<*>, Int>>

    beforeTest {
        val spoon = Launcher()
        spoon.factory.environment.apply {
            isIgnoreDuplicateDeclarations = true
            ignoreSyntaxErrors = true
        }
        spoon.addInputResource(NpathDoConstructsTest::class.java.getResource("/DoTests.java").file)
        spoon.buildModel()
        npathValues = npath(spoon.model)
    }

    "doTest1" { npathValues.getByName("doTest1") shouldBe 2 }
    "doTest2" { npathValues.getByName("doTest2") shouldBe 3 }
    "doAndIf" { npathValues.getByName("doAndIf") shouldBe 5 }
})
