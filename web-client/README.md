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