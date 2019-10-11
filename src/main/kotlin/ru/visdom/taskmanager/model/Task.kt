package ru.visdom.taskmanager.model

import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "task")
data class Task(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long = 0,

        @Column(name = "name")
        val name: String,

        @Column(name = "decription")
        val description: String,

        @Column(name = "start_date")
        val startDate: LocalDateTime,

        @Column(name = "end_date")
        val endDate: LocalDateTime,

        @Column(name = "status_id")
        val statusId: Long,

        @Column(name = "importancelevel_id")
        val importanceLevelId: Long,

        @Column(name = "employee_id")
        val employeeId: Long
)