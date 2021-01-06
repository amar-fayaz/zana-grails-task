package coding.challenge

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }
        "/entities"(resources:"EntityRest")
        "/contents"(resources:"ContentRest")
        "/synonyms"(resources:"SynonymRest")
        "/"(view:"/index")
        "500"(view:'/error')
        "404"(view:'/notFound')
    }
}
