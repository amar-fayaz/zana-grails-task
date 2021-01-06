package coding.challenge

class Synonym {

    String name

    static belongsTo = Entity
    static hasMany = [entity: Entity]
    
    static constraints = {
        name blank: false, unique: true
    }

    String toString() {return name}
}
