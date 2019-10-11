package ru.visdom.taskmanager.model

import javax.persistence.*

@Entity
@Table(name = "user")
data class User (
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long = 0,

        @Column(name = "first_name")
        val firstName: String,

        @Column(name = "last_name")
        val lastName: String,

        @Column(name = "patronymic")
        val patronymic: String,

        @Column(name = "email")
        val email: String,

        @Column(name = "password")
        val password: String
)