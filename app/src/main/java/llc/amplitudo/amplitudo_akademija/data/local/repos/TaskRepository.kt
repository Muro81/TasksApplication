package llc.amplitudo.amplitudo_akademija.data.local.repos

import llc.amplitudo.amplitudo_akademija.data.local.models.Task

class TaskRepository {

    fun getTasks(): ArrayList<Task> {
        return arrayListOf(
            Task(id = 1, isDone = false, taskDescription = "Todo Description 1"),
            Task(id = 2, isDone = true, taskDescription = "Todo Description 2"),
            Task(id = 3, isDone = false, taskDescription = "Todo Description 3"),
            Task(id = 4, isDone = true, taskDescription = "Todo Description 4"),
            Task(id = 5, isDone = true, taskDescription = "Todo Description 5"),
            Task(id = 6, isDone = false, taskDescription = "Todo Description 6"),
            Task(id = 7, isDone = false, taskDescription = "Todo Description 7"),
            Task(id = 8, isDone = true, taskDescription = "Todo Description 8"),
            Task(id = 9, isDone = false, taskDescription = "Todo Description 9"),
            Task(id = 10, isDone = false, taskDescription = "Todo Description 10"),
            Task(id = 11, isDone = true, taskDescription = "Todo Description 11"),
        )
    }
}