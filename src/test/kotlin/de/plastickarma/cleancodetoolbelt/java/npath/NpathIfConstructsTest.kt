package de.plastickarma.cleancodetoolbelt.java.npath

import de.plastickarma.cleancodetoolbelt.java.getByName
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import spoon.Launcher
import spoon.reflect.declaration.CtMethod

class NpathIfConstructsTest : StringSpec({

    lateinit var npathValues: List<Pair<CtMethod<*>, Int>>

    beforeTest {
        val spoon = Launcher()
        spoon.factory.environment.apply {
            isIgnoreDuplicateDeclarations = true
            ignoreSyntaxErrors = true
        }
        spoon.addInputResource(NpathIfConstructsTest::class.java.getResource("/IfTests.java").file)
        spoon.buildModel()
        npathValues = npath(spoon.model)
    }

    "ifTest1" { npathValues.getByName("ifTest1") shouldBe 4 }
    "ifTest2" { npathValues.getByName("ifTest2") shouldBe 16 }
    "nestedIfTest1" { npathValues.getByName("nestedIfTest1") shouldBe 3 }
    "ifElseTest1" { npathValues.getByName("ifElseTest1") shouldBe 3 }
})
