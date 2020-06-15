package actions

import character.Character
import Environment
import engine.Action
import kitchen.cookingMicroActions.CloseFrige
import kitchen.cookingMicroActions.LookInFrige
import engine.MicroAction
import kitchen.cookingMicroActions.OpenFrige

class StrangeAction(character: Character, environment: Environment) : Action(character, environment) {
    var finished = false
    var curMicroAction : MicroAction? = null
    var status : Int = 0
    init{
        println("i'm created, $this")
        onAlert()
    }
    override fun onEvent() {
    }

    override fun isFinished(): Boolean {
        return finished
    }

    override fun onPause(): Array<MicroAction> {
        return arrayOf()
    }

    override fun onResume() {
    }

    override fun onAlert() {
        when(status){
            0 -> {
                curMicroAction = OpenFrige()
                character.brain.alert.addAlert(environment.current_time + 2000, this)
            }
            1 -> {
                character.brain.alert.addAlert(environment.current_time + 30000, this)
                curMicroAction = LookInFrige()
            }
            2 -> {
                character.brain.alert.addAlert(environment.current_time + 2000, this)
                curMicroAction = CloseFrige()
            }
            3 -> finished = true
        }
        status++
    }

    override fun getCurrentMicroAction(): MicroAction? {
        return curMicroAction
    }

}