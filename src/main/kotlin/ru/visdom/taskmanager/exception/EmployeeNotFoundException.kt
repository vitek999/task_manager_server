package ru.visdom.taskmanager.exception

import java.lang.RuntimeException

class EmployeeNotFoundException(override val message: String): RuntimeException(message)