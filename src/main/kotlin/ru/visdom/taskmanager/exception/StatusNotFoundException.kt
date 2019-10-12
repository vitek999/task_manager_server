package ru.visdom.taskmanager.exception

import java.lang.RuntimeException

class StatusNotFoundException(override val message: String): RuntimeException(message)