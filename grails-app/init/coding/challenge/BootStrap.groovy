package coding.challenge

class BootStrap {

    def init = { servletContext ->
        def entA = new Entity(title: "A", description:"A").save(failOnError: true)
        def entN = new Entity(title: "B", description:"B").save(failOnError: true)
        def contX = new Content(title: "X", description:"X", entity:entA).save(failOnError: true)
    }
    def destroy = {
    }
}
