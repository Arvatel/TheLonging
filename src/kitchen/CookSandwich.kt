package kitchen

import Environment
import engine.Action
import character.Character
import kitchen.cookingMicroActions.*
import engine.MicroAction
import kitchen.cookingMicroActions.OpenFrige as OpenFrige

class CookSandwich(character: Character, environment: Environment) : Action(character, environment) {
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
                character.brain.alert.addAlert(environment.current_time + 10000, this)
                curMicroAction = PrepareFoodForCooking()
            }
            3 -> {
                character.brain.alert.addAlert(environment.current_time + 120000, this)
                curMicroAction = CutFood()
            }
            4 -> {
                character.brain.alert.addAlert(environment.current_time + 30000, this)
                curMicroAction = MakeSandwich()
            }
            5 -> {
                character.brain.alert.addAlert(environment.current_time + 150000, this)
                curMicroAction = CleanTableAfterCooking()
            }
            6 -> {
                character.brain.alert.addAlert(environment.current_time + 300000, this)
                curMicroAction = EatSomething()
            }
            7 -> {
                character.brain.alert.addAlert(environment.current_time + 300000, this)
                curMicroAction = CleanAfterEating()
            }
            8 -> finished = true
        }
        status++
    }

    override fun getCurrentMicroAction(): MicroAction? {
        return curMicroAction
    }
}