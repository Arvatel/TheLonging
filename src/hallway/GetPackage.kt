package hallway

import Environment
import engine.Action
import character.Character
import hallway.microActions.PutPackage
import hallway.microActions.ReceivePackage
import engine.MicroAction

class GetPackage(character: Character, environment: Environment) : Action(character, environment) {
    private var status : Int = 0
    private var finished : Boolean = false
    private var curMicroAction : MicroAction? = null
    init {
        println("I'm created $this")
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
                character.brain.alert.addAlert(environment.current_time + 120000, this)
                curMicroAction = ReceivePackage()
            }
            1 -> {
                character.brain.alert.addAlert(environment.current_time + 10000, this)
                curMicroAction = PutPackage()
            }
            2 -> finished = true
        }
        status++
    }

    override fun getCurrentMicroAction(): MicroAction? {
        return curMicroAction
    }
}