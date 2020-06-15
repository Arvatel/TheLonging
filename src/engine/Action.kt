package engine

import character.Character
import Environment

abstract class Action(val character: Character, val environment: Environment) {
    abstract fun onEvent()
    abstract fun isFinished() : Boolean
    abstract fun onPause() : Array<MicroAction>
    abstract fun onResume()
    abstract fun onAlert()
    abstract fun getCurrentMicroAction() : MicroAction?
}