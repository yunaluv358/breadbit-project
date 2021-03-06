import React, {useState} from "react";
import axios from 'axios';
import { useHistory, Link } from 'react-router-dom';
import makeStyles from "@material-ui/core/styles/makeStyles";

const useStyles = makeStyles((theme) => ({
    paper: {
        marginTop: theme.spacing(8),
        display: 'flex',
        flexDirection: 'column',
        alignItems: 'center',
    },
    find : {
        margin : 8
    },
    box : {
        borderRadius : "1em",
        boxShadow : "5px 5px 2px 2px gray",
    },
    font : {
        fontFamily: 'italic',
        color : "brown",
        fontSize : "30px",
        margin : "12px 0px"
    }
}));

export const ChatBotLogin = () => {
    const [userId,setUserId] = useState('')
    const [password,setPassword] = useState('')
    const history = useHistory();
    const classes = useStyles();
    const onAdmin = e => {
        e.preventDefault()
        setUserId('admin119')
        setPassword('1111!@')
    }
    const handleLogout = e=> {
        sessionStorage.removeItem('user')
        window.location.reload()
    }
    const SignInButton = e => {
        e.preventDefault()
        const userData = {
            userId: userId,
            password: password
        }
            axios.post(`http://localhost:8080/user/signIn`, userData)
                .then(response => {
                        sessionStorage.setItem("user", JSON.stringify(response.data))
                        history.push("/shipping")
                    }
                ).catch(
                error => {
                    history.push("/signup")
                    throw (error)
                }
            )
    }
    return <>
        {sessionStorage.user &&
            <a href={'/shipping'}>
                로그인 되어있습니다 누르시면 배송조회로 넘어값니다
            </a>
        }
        {!sessionStorage.user &&
        <div className={classes.paper}>
            <div className="h3-bread">&nbsp;</div>
            <form className={classes.box}>
                <div>배송조회를 위해 로그인 바랍니다</div>
                <h3 className={classes.font}>Bread</h3>
                <div className="form-group">
                    <label>UserId</label>
                    <input type="email" className="form-control" value={userId} onChange={e => setUserId(e.target.value)} placeholder="Enter email" />
                </div>
                <div className="form-group">
                    <label>Password</label>
                    <input type="password" className="form-control" value={password} onChange={e=>setPassword(e.target.value)} placeholder="Enter password" />
                </div>
                <button type="submit" className="btn btn-primary btn-block" onClick={SignInButton}>Submit</button>
                <p className={classes.find}>
                    <a className={classes.find} href="/findId">아이디찾기</a>
                    <a className={classes.find} href="/findPw">비밀번호찾기</a>
                    <a className={classes.find} href="/signup">회원가입</a>
                </p>
            </form>
        </div> 
        }

    </>
}