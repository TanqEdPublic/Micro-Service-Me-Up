### Requirements

* Node installed globally on the machine or inside virtual project environment
  1. _Note that some parameters inside webpack.config.js may change depending on the choice of environment._
  2. _Node is used to install other project dependent modules like ReactJS library, babel, webpack, etc._

* 
*
*
### Building project package

mvn package 

### Track changes in client files
npm run-script watch

Webpack watch cannot update bundle.js inside running Tomcat container.

To update bundle in Tomcat cache need to repackage a project.

### Webpack Loaders

Ref. page: https://webpack.js.org/concepts/loaders/

### Webpack Plugins 

To solve issues with integrating ReactJs with other
js scripts like jQuery or Tether, we can use plugins section
in `webpack.config.js`.

Example solving an issue: https://stackoverflow.com/questions/40288268/using-jquery-and-bootstrap-with-es6-import-for-react-app

### Limitations 

Need to repackage Spring Boot application that hosts ReactJs
client in order for Tomcat to serve new client bundle.

### ReactJS Router

To manage navigation between react components,
you need to get React Router components.

* ``npm install react-router --save``
* ``npm install react-router-dom --save``

Add this dependencies to ``package.json`` for 
webpack to include components into bundle.

Three important components to know.

* ``BrowserRouter`` - This is the Router itself. Uses HTML5 history API.
Synchronizes UI content to what is written in address bar (URL).

* ``Route`` - Links component to it's respective URI. Responsible
for rendering of the UI.

* ``Link`` - URL wrapper component that is used for redirect.

__Additional libraries__
 
* ``createBrowserHistory`` - Comes with ``react-router`` library.
This library makes sure that application history is maintained
consistently in respect to user actions. Added as a parameter 
to router component ``BrowserRouter``


__Example__

````JavaScript
import React from "react"
import {BrowserRouter, Route, Link} from "react-router-dom"
import createBrowserHistory from "history/createBrowserHistory"
import Home from './home';

const Home = () => (
    <Home/>
)

class Navigation extends React.Component {
    render() {
        return (
            
            <BrowserRouter history ={history}>
                <div>
                    <ul>
                        <li>
                            <Link to="/">Home</Link>
                        </li>
                    </ul>
                </div>
                <Route exact path="/" component = {Home}/>
            </BrowserRouter>
        )
    }
}
export default Navigation
````