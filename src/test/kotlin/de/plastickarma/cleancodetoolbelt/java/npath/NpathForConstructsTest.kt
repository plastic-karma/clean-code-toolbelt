package de.plastickarma.cleancodetoolbelt.java.npath

import de.plastickarma.cleancodetoolbelt.java.getByName
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import spoon.Launcher
import spoon.reflect.declaration.CtMethod

class NpathForConstructsTest : StringSpec({

    lateinit var npathValues: List<Pair<CtMethod<*>, Int>>

    beforeTest {
        val spoon = Launcher()
        spoon.factory.environment.apply {
            isIgnoreDuplicateDeclarations = true
            ignoreSyntaxErrors = true
        }
        spoon.addInputResource(NpathForConstructsTest::class.java.getResource("/ForTests.java").file)
        spoon.buildModel()
        npathValues = npath(spoon.model)
    }

    "forTest" { npathValues.getByName("forTest") shouldBe 4 }
})
