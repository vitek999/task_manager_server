package ru.visdom.taskmanager.exception

import java.lang.RuntimeException

class TaskNotFoundException(override val message: String): RuntimeException(message)