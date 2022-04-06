import React, {Component} from "react";
import ListCoursesComponent from "./ListCoursesComponent";
import { BrowserRouter as Router, Route, Switch} from 'react-router-dom';
import CourseComponent from "./CourseComponent";

class InstructorApp extends Component{

    render() {
        return (
            <Router>
                <>
                    <h1>Instructor Application</h1>
                    <Switch>
                        <Route path="/" exact component={props => <ListCoursesComponent {...props} />} />
                        <Route path="/courses" exact component={props => <ListCoursesComponent {...props} />} />
                        <Route path="/courses/:id" component={props => <CourseComponent {...props} />} />
                    </Switch>
                </>
            </Router>
        )
    }

}

export default InstructorApp