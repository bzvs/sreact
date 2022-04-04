import React, {Component} from "react";
import ListCoursesComponent from "./ListCoursesComponent";
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import CourseComponent from "./CourseComponent";

class InstructorApp extends Component{

    render() {
        return (
            <Router>
                <>
                    <h1>Instructor Application</h1>
                    <Routes>
                        <Route path="/" element={<ListCoursesComponent/>} />
                        <Route path="/courses" element={<ListCoursesComponent/>} />
                        <Route path="/courses/:id" element={<CourseComponent/>} />
                    </Routes>
                </>
            </Router>
        )
    }

}

export default InstructorApp