# ![CF](http://i.imgur.com/7v5ASc8.png) Spring RESTful Routing

## Resources
* [Baeldung: Spring Request Mapping](http://www.baeldung.com/spring-requestmapping)

Choose your own resource to model for this lab (mountains, ramen, bikes, etc.)

Configure a Spring server to have RESTful routing to map HTTP requests to
classes that interact with and manipulate in-memory storage (not connected to
a database.) Follow the RESTful pattern.

Create HTML forms with AJAX-intercepted buttons the create, read, update and
delete resources.

Make sure your requests accurately obtain user input via URL parameters, or
by accessing the body of POST requests.

Make sure your server fails gracefully. The server shouldn't crash and the
database shouldn't be corrupted in any way if a user attempts to read or
manipulate information that doesn't exist.

## Stretch Goals
Build HTML pages to display a list of your resource with links to the create
and edit pages.

<table><thead>
<tr>
<th>Action</th>
<th>HTTP Method</th>
<th>Url Template</th>
<th>HTML formMountain?</th>
<th>CRUD</th>
</tr>
</thead><tbody>
<tr>
<td>INDEX</td>
<td>GET</td>
<td>/products</td>
<td></td>
<td>Read All</td>
</tr>
<tr>
<td>SHOW</td>
<td>GET</td>
<td>/products/{id}</td>
<td></td>
<td>Read One</td>
</tr>
<tr>
<td>NEW</td>
<td>GET</td>
<td>/products/new</td>
<td>Yes</td>
<td></td>
</tr>
<tr>
<td>CREATE</td>
<td>POST</td>
<td>/products</td>
<td></td>
<td>Create</td>
</tr>
<tr>
<td>EDIT</td>
<td>GET</td>
<td>/products/{id}/edit</td>
<td>Yes</td>
<td></td>
</tr>
<tr>
<td>UPDATE</td>
<td>PUT</td>
<td>/products/{id}</td>
<td></td>
<td>Update</td>
</tr>
<tr>
<td>DESTROY</td>
<td>DELETE</td>
<td>/products/{id}</td>
<td></td>
<td>Destroy</td>
</tr>
</tbody></table>


## Code Samples
#### Annotate a Class with RequestMappings as a Controller
```java
@Controller
public class MyController {
  @RequestMapping(value = "/ex/foos", method = RequestMethod.GET)
  @ResponseBody
  public String getFoosBySimplePath() {
      return "Get some Foos";
  }
}
```

#### Get Information via URL Parameters
```java
@RequestMapping(value = "/params")
@ResponseBody
public String getUrlParams(@RequestParam("id") String name) {
    return "Hello " + name + "!";
}
```

#### Differentiate Requests by HTTP Methods
```java
@RequestMapping(value = "/example", method = RequestMethod.GET)
@ResponseBody
public String getExample() {
    return "GET some foo";
}

@RequestMapping(value = "/example", method = RequestMethod.POST)
@ResponseBody
public String postExample() {
    return "POST some foo";
}
```

#### Access POST Body
```java
@RequestMapping(value = "/postbody", method = RequestMethod.POST)
@ResponseBody
public String saveData(HttpServletRequest request){
   String name = request.getParameter("name");
   return "Hello POST body name: " + name;
}
```

## Submission Instructions
* Work in a fork of this repository
* Work in a branch on your fork
* Write all of your code in a directory named `lab-` + `<your name>` **e.g.** `lab-susan`
* Open a pull request to this repository
* Submit on canvas a question and observation, how long you spent, and a link to
  your pull request
