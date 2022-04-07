import React, {Component} from "react";
import ListCoursesComponent from "./ListCoursesComponent";
import { BrowserRouter as Router, Route, Switch, } from 'react-router-dom';
import CourseComponent from "./CourseComponent";
import LoginComponent from "./LoginComponent";
import AuthenticatedRoute from "./AuthenticatedRoute";

class InstructorApp extends Component{

    render() {
        return (
            <Router>
                <>
                    <h1>Instructor Application</h1>
                    <Switch>
                        <Route path="/" exact component={props => <LoginComponent {...props} />} />
                        <Route path="/login" exact component={props => <LoginComponent {...props} />} />
                        <AuthenticatedRoute  path="/courses" exact component={props => <ListCoursesComponent {...props} />} />
                        <AuthenticatedRoute  path="/courses/:id" component={props => <CourseComponent {...props} />} />
                    </Switch>
                </>
            </Router>
        )
    }

}

export default InstructorApp