package coding.challenge

class Entity {
    String title
    String description

    static hasMany = [contents: Content, synonyms: Synonym]

    static constraints = {
        title blank:false, unique:true
        description blank:true
    }

    String toString() {return title}
}
