package ru.visdom.taskmanager.exception

import java.lang.RuntimeException

class ImportanceLevelNotFoundException(override val message: String): RuntimeException(message)