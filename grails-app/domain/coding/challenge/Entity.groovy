package coding.challenge

class Entity {
    String title
    String description

    static constraints = {
        title blank:false, unique:true
        description blank:true
    }
}
