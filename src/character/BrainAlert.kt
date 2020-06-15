package character

import Environment
import java.util.PriorityQueue
// TODO переделать конструктор

class BrainAlert(val character: Character, private val environment: Environment) {
    private var queue : PriorityQueue<TimeEvent> = PriorityQueue<TimeEvent>()


    fun getNextEventTime() : Long{
        if (queue.isEmpty())
            return -1
        return queue.peek().time
    }

    fun addAlert(time: Long, brainAlert: BrainAlertInterface){
        val newTimeEvent : TimeEvent = TimeEvent(time, brainAlert)
        queue.add(newTimeEvent)
    }

    fun alert(){
        assert(!queue.isEmpty())
        assert(environment.current_time == queue.peek().time)
        queue.peek().alert()
        queue.remove()
    }

}

class TimeEvent(val time : Long, val brainAlert: BrainAlertInterface) : Comparable<TimeEvent>{
    override fun compareTo(other: TimeEvent): Int {
        return time.compareTo(other.time)
    }
    fun alert(){
        brainAlert.onAlert()
    }
}