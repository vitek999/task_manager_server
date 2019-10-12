package ru.visdom.taskmanager.exception

import java.lang.RuntimeException

class UserNotFoundException(override val message: String): RuntimeException(message)