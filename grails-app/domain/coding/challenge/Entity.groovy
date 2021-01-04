package coding.challenge

class Entity {
    String title
    String description

    static hasMany = [contents: Content]

    static constraints = {
        title blank:false, unique:true
        description blank:true
    }

    String toString() {return title}
}
