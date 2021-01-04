package coding.challenge

class BootStrap {

    def init = { servletContext ->
        def entA = new Entity(title: "A", description:"A").save(failOnError: true)
        def entN = new Entity(title: "B", description:"B").save(failOnError: true)
    }
    def destroy = {
    }
}
