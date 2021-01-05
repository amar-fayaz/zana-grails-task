package coding.challenge

import grails.converters.JSON
import grails.rest.RestfulController

class EntityRestController extends RestfulController{
    static responseFormats = ["json", "xml"]

    EntityRestController() {
        super(Entity)
    }

    @Override
    def getObjectToBind() {
        Map paramsObj = JSON.parse(request)
        println paramsObj.dump()
        if (paramsObj.contents) {
            for (int i=0; i<paramsObj.contents.size();i++){
                if (paramsObj.contents[i].title){
                    String titleVal = paramsObj.contents[i].title
                    Content returnVal = Content.findByTitle(titleVal)
                    
                    if (!returnVal){
                        if (request.method == "POST" || request.method == "PUT"){
                            paramsObj.contents[i] = new Content(paramsObj.contents[i])
                        } else {
                            response.sendError(400, "Cannot find entity with the title ${titleVal}")
                        }
                    } else {
                        paramsObj.contents[i] = returnVal
                    }
                }
            }
        }
        paramsObj
    }
}
