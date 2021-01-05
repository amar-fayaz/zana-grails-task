package coding.challenge

class Content {
    String title
    String description

    static hasOne = [entity: Entity]
    static belongsTo = Entity

    static constraints = {
        title blank:false, unique:true
        description blank:true
        entity nullable:true
    }

    String toString() {return title}
}
