package de.plastickarma.cleancodetoolbelt.java

import spoon.reflect.declaration.CtMethod

fun List<Pair<CtMethod<*>, Int>>.getByName(name: String) = this.first { it.first.simpleName == name }.second
