/**
 * 
 */
/**
 * @author BABLU
 * 
 * Application of CyclicBarrier in real world >
Let’s say 10 friends (friends are threads) have planned for picnic on place A (Here place A is common barrier point). And they all decided to play certain game (game is event) only on everyones arrival at place A. So, all 10 friends must wait for each other to reach place A before launching event. 

 Now, when all threads have reached common barrier point (i.e. all friends have reached place A) >
All waiting threads are released  (All friends can play game), and 
Event can be triggered (they will start playing game).

Why barrier is called Cyclic?
The barrier is called cyclic because CyclicBarrier can be reused after -
All the waiting threads are released and 
event has been triggered. 
 *
 */
package concurrent.cyclicbarrier;