package engine

import Environment
import character.Character

//TODO подумать над названием класса
class System {
    val environment : Environment = Environment()
    val character : Character = Character(environment)

    fun mainLoop(){
        character.onCreate()
        while(environment.current_time < 180L * 24 * 60 * 60 * 1000) {
            val nextEventTime: Long = character.brain.alert.getNextEventTime()
            if (nextEventTime.equals(-1)) {
                environment.current_time = 180L * 24 * 60 * 60 * 1000
                continue
            }
            environment.current_time = nextEventTime
            println(environment.current_time)
            println("закончил выполнение: ${character.brain.getCurrentAction().getCurrentMicroAction()!!.getDescription()}")
            character.brain.alert.alert()
        }
    }
}