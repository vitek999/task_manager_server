package ru.visdom.taskmanager.exception

import java.lang.RuntimeException

class CompanyNotFoundException(override val message: String): RuntimeException(message)