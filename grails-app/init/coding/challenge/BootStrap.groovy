package coding.challenge

class BootStrap {

    def init = { servletContext ->
        def mTwain = new Entity(title: "Mark Twain", description: "1835")
                    .addToContents(new Content(title: "The Adventures of Tom Sawyer", description: "1876"))
                    .addToContents(new Content(title: "Speeches", description: "1910"))
                    .save(failOnError:true)

        def novel = new Synonym(name: "Novel").save(failOnError: true)
        def children = new Synonym(name: "Children").save(failOnError: true)
    }
    def destroy = {
    }
}
