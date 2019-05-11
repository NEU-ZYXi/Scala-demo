
// Runnable/Callable
// Runnable has a single method that returns no value
trait Runnable {
  def run(): Unit 
}

// Callable returns a value
trait Callable[V] {
  def call(): V 
}


// Threads, built on Java concurrency model, a thread takes a Runnable
val hello = new Thread(new Runnable {
  def run() {
    println("hello world")
  }
})
hello.start


// Executors, have an ExecutorService using static methods on Executors object
class Handler(socket: Socket) extends Runnable {
  def message = (Thread.currentThread.getName() + "\n").getBytes
  
  def run() {
    socket.getOutputStream.write(message)
    socket.getOutputStream.close()
  }
}

class NetworkService(port: Int, poolSize: Int) extends Runnable {
  val serverSocket = new ServerSocket(port)
  val pool: ExecutorService = Executors.newFixedThreadPool(poolSize)
  
  def run() {
    try {
      while (true) {
        val socket = serverSocket.accept()
        pool.execute(new Handler(socket))
      }
    } finally {
      pool.shutdown() 
    }
  }
}


// Futures, represents an synchronous computation, an Executor returns a Future, call a blocking Await.result() when we need the result which is wrapped in a Future
// a FutureTask is a Runnable and is designed to be run by an Executor
val future = new FutureTask[String](new Callable[String]() {
  def call(): String {
    searcher.search(target)  
  }
})
executor.execute(future)
val blockingResult = Await.result(future)


// Thread Safe tools
// synchronization
class Person(var name: String) {
  def set(changeName: String) {
    this.synchronized {
      name = changeName 
    }
  }
}

// volatile
class Person(@volatile var name: String) {
  def set(changeName: String) {
    name = changeName 
  }
}

// CountDownLatch, a mechanism for multiple threads to communicate with each other
val doneSignal = new CountDownLatch(2)
doAsyncWork(1)
doAsyncWork(2)
doneSignal.await()
println("both workers finished")

// AtomicInteger/Long/Boolean, AtomicReference


// Producer/Consumer model, for async computation and they only communicate via a Queue
// Concrete producer
class Producer[T](path: String, queue: BlockingQueue[T]) extends Runnable {
  def run() {
    Source.fromFile(path, "utf-8").getLines.foreach { line => 
      queue.put(line)
    }
  }
}

// Abstract consumer
abstract class Consumer[T](queue: BlockingQueue[T]) extends Runnable {
  def run() {
    while (true) {
      val item = queue.take()
      consume(item)
    }
  }
}

val queue = new LinkedBlockingQueue[String]()

// One thread for producer
val producer = new Producer[String]("users.txt", queue)
new Thread(producer).start()

trait UserMaker {
  def makeUser(line: String) = line.split(",").match {
    case Array(name, userId) => User(name, userId.trim().toInt) 
  }
}

class IndexerConsumer(index: InvertedIndex, queue: BlockingQueue[String]) extends Consumer[String](queue) with UserMaker {
  def consume(t: String) = index.add(makeUser(t)) 
}

val cores = 8
val pool = Executors.newFixedThreadPool(cores)

for (i <- i to cores) {
  pool.submit(new IndexerConsumer[String](index, queue)) 
}




