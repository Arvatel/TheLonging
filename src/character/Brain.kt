package character

import Environment
import engine.Action
import hallway.GetPackage

class Brain(val character: Character, private val environment: Environment) {
    val alert : BrainAlert = BrainAlert(character, environment)
    private var todoList : ArrayList<Action> = arrayListOf()

    fun onCreate(){
        generateActionsInFreeTime()
    }

    fun getCurrentAction() : Action {
        for (item in todoList)
            if (item.getCurrentMicroAction() != null)
                return item
        assert(false, {"Отсутствуют активные actions"})
        return todoList[0]
    }

    fun updateTodoList(action: Action){
        if(action.isFinished()) {
            println("delete action $action")
            todoList.remove(action)
        }
        if (!checkActiveAction())
            generateActionsInFreeTime()
    }

    private fun checkActiveAction() : Boolean{
        for (item in todoList)
            if(item.getCurrentMicroAction() != null)
                return true
        return false
    }

    fun moveToFreeTime(action: Action){
        todoList.remove(action)
        todoList.add(action)
    }

    private fun generateActionsInFreeTime(){
        addNormalAction(GetPackage(character, environment))
    }

    private fun addImportantAction(action: Action){
        todoList.add(0, action)
    }

    private fun addNormalAction(action: Action){
        todoList.add(action)
    }

}