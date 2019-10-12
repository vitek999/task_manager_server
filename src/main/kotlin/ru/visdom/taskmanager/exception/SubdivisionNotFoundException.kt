package ru.visdom.taskmanager.exception

import java.lang.RuntimeException

class SubdivisionNotFoundException(override val message: String) : RuntimeException(message)