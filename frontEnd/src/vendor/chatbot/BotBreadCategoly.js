import React, {useEffect, useState} from "react";
import '../../bread/bread-search.css'
import $ from 'jquery'
import axios from "axios";
import {makeStyles} from "@material-ui/styles";

const useStyle = makeStyles(()=>({
    size:{
        width: 'auto',
        height: 'auto',
        maxWidth: 'px',
        maxHeight: '100px'
    }
}))


export const BotBreadCategoly = () => {
    const [breadAll, setBreadAll] = useState([])
    const [select1result, setSelect1result] = useState([])
    const [select2result, setSelect2result] = useState([])
    const classes = useStyle()
    useEffect(() => {
        axios.get(`http://localhost:8080/bread/findAll`)
            .then((response) => {
                    setBreadAll(response.data)
                }
            ).catch((error => {
                throw (error)
            }
        ))

    }, [])

    const init = (e) => {
        $(window).scrollTop($('div.find').offset().top - $('div.navbar').height());
        $('#result').hide();
        $('#chart1 li').removeClass('active');
        $(":input:radio[name=chart1]:checked").prop('checked', false);
        $('#chart2 li').removeClass('active');
        $(":input:checkbox[name=chart2]:checked").each(function () {
            $(e).prop('checked', false);
        });
    }

    const select1 = (e, value, breadAll) => {
        let temp = []
        for (let i of breadAll) {
            if(value === i.option){
                temp.push(i)
            }
        }
        for (let i of temp) {
        }
        setSelect1result(temp)


        $('#chart1 li').removeClass('active');
        $(e).addClass('active');
        $(e).children().prop('checked',true);
    }


    const select2 = (e, value, select1result) => {

        let temp = []
        for (let i of select1result) {
            if (value === i.allergy) {
                temp.push(i)
            }

        }
        for (let i of temp) {
        }
        setSelect2result(temp)


        if ($(e).children().prop('checked') == true) {
            $(e).removeClass('active');
            $(e).children().prop('checked', false);
            var imgpath = 'https://thebreadblue.com/theme/eb4_shop_005/page/img/findbread/allergy' + ($(e).index() + 1) + '.png';
            $(e).children().next().css('background-image', 'url(' + imgpath + ')');
        } else {
            $(e).addClass('active');
            $(e).children().prop('checked', true);
            var imgpath = 'https://thebreadblue.com/theme/eb4_shop_005/page/img/findbread/on_allergy' + ($(e).index() + 1) + '.png';
            $(e).children().next().css('background-image', 'url(' + imgpath + ')');
        }
    }


    const result = (e) => {

        $('#resultList div.col-xs-6').hide(e);

        $('#result').show(e);

        $('#result ul li').hide(e);

    }

    const searchDetail = bread => {
        localStorage.setItem('searchBread', JSON.stringify(bread))
    }

    return (<>
            {/*<Navigation/>*/}
            <div>
                <div className="userDiv">
                    <div className="find">
                        <p className="title">
                            <img src="https://thebreadblue.com/theme/eb4_shop_005/page/img/findbread/logo.png"
                                 className="logo"/>
                        </p>
                        <p className="stitle">
                            TASTE FOR ALL
                        </p>
                        <p className="desc">
                            나에게 맞는 더브레드블루<br className="mobile_br"/>제품을 찾아 볼까요?
                        </p>
                        <p className="stitle2">
                            구매 목적
                        </p>
                        <p className="title">
                            <img src="https://thebreadblue.com/theme/eb4_shop_005/page/img/findbread/check.png"
                                 className="check"/>
                        </p>
                        <ul id="chart1">
                            <li onClick={(e) => select1(e.target, "식사대용", breadAll)} value="식사대용">
                                <input type="radio" name="chart1"/><p>식사대용</p> <div className="circle"></div>
                            </li>
                            <li onClick={(e) => select1(e.target, "간식대용", breadAll)} value="간식대용">
                                <input type="radio" name="chart1"/><p>간식대용</p> <div className="circle"></div>
                            </li>
                            <li onClick={(e) => select1(e.target, "다이어트", breadAll)} value="다이어트">
                                <input type="radio" name="chart1"/><p>다이어트</p> <div className="circle"></div>
                            </li>
                            <li onClick={(e) => select1(e.target, "선물", breadAll)}
                                className="active"><input type="radio" name="chart1" value="선물"/><p>선물</p><div className="circle"></div>
                            </li>
                        </ul>
                        <p className="stitle2" style={{"margin-top": '50px'}}>
                            원하는 재료
                        </p>
                        <p className="title">
                            <img src="https://thebreadblue.com/theme/eb4_shop_005/page/img/findbread/check.png"
                                 className="check"/>
                        </p>
                        <ul id="chart2">
                            <li onClick={(e) => select2(e.target, "아몬드", select1result)}>
                                <input type="checkbox" name="chart2" value="아몬드"/>
                                <div className="circle"
                                     style={{backgroundImage: "url('https://thebreadblue.com/theme/eb4_shop_005/page/img/findbread/allergy1.png')"}}></div>
                                <p>아몬드</p>
                            </li>
                            <li onClick={(e) => select2(e.target, "호두", select1result)}>
                                <input type="checkbox" name="chart2" value="호두"/>
                                <div className="circle"
                                     style={{backgroundImage: "url('https://thebreadblue.com/theme/eb4_shop_005/page/img/findbread/allergy2.png')"}}></div>
                                <p>호두</p>
                            </li>
                            <li onClick={(e) => select2(e.target, "땅콩", select1result)}>
                                <input type="checkbox" name="chart2" value="땅콩"/>
                                <div className="circle"
                                     style={{backgroundImage: "url('https://thebreadblue.com/theme/eb4_shop_005/page/img/findbread/allergy3.png')"}}></div>
                                <p>땅콩</p>
                            </li>
                            <li onClick={(e) => select2(e.target, "피스타치오", select1result)}>
                                <input type="checkbox" name="chart2" value="피스타치오"/>
                                <div className="circle"
                                     style={{backgroundImage: "url('https://thebreadblue.com/theme/eb4_shop_005/page/img/findbread/allergy4.png')"}}></div>
                                <p>피스타치오</p>
                            </li>
                            <li onClick={(e) => select2(e.target, "캐슈넛", select1result)}>
                                <input type="checkbox" name="chart2" value="캐슈넛"/>
                                <div className="circle"
                                     style={{backgroundImage: "url('https://thebreadblue.com/theme/eb4_shop_005/page/img/findbread/allergy5.png')"}}></div>
                                <p>캐슈넛</p>
                            </li>
                            <li onClick={(e) => select2(e.target, "마카마디아", select1result)}>
                                <input type="checkbox" name="chart2" value="마카마디아"/>
                                <div className="circle"
                                     style={{backgroundImage: "url('https://thebreadblue.com/theme/eb4_shop_005/page/img/findbread/allergy6.png')"}}></div>
                                <p>마카마디아</p>
                            </li>
                            <li onClick={(e) => select2(e.target, "밀가루", select1result)}>
                                <input type="checkbox" name="chart2" value="밀가루"/>
                                <div className="circle"
                                     style={{backgroundImage: "url('https://thebreadblue.com/theme/eb4_shop_005/page/img/findbread/allergy7.png')"}}></div>
                                <p>밀가루</p>
                            </li>
                            <li onClick={(e) => select2(e.target, "콩(대두)", select1result)}>
                                <input type="checkbox" name="chart2" value="콩(대두)"/>
                                <div className="circle"
                                     style={{backgroundImage: "url('https://thebreadblue.com/theme/eb4_shop_005/page/img/findbread/allergy8.png')"}}></div>
                                <p>콩(대두)</p>
                            </li>
                            <li onClick={(e) => select2(e.target, "설탕", select1result)}>
                                <input type="checkbox" name="chart2" value="설탕"/>
                                <div className="circle"
                                     style={{backgroundImage: "url('https://thebreadblue.com/theme/eb4_shop_005/page/img/findbread/allergy9.png')"}}></div>
                                <p>설탕</p>
                            </li>
                            <li onClick={(e) => select2(e.target, "토마토", select1result)}>
                                <input type="checkbox" name="chart2" value="토마토"/>
                                <div className="circle"
                                     style={{backgroundImage: "url('https://thebreadblue.com/theme/eb4_shop_005/page/img/findbread/allergy10.png')"}}></div>
                                <p>토마토</p>
                            </li>
                            <li onClick={(e) => select2(e.target, "건포도", select1result)}>
                                <input type="checkbox" name="chart2" value="건포도"/>
                                <div className="circle"
                                     style={{backgroundImage: "url('https://thebreadblue.com/theme/eb4_shop_005/page/img/findbread/allergy11.png')"}}></div>
                                <p>건포도</p>
                            </li>
                            <li onClick={(e) => select2(e.target, "복숭아", select1result)}>
                                <input type="checkbox" name="chart2" value="복숭아"/>
                                <div className="circle"
                                     style={{backgroundImage: "url('https://thebreadblue.com/theme/eb4_shop_005/page/img/findbread/allergy12.png')"}}></div>
                                <p>복숭아</p>
                            </li>
                        </ul>
                        <div id="buttonArea">
                            <button type="button" onClick={(e) => init(e)}>초기화</button>
                            <button type="button" id="confirm" onClick={(e) => result(e)}>결과보기</button>
                        </div>
                    </div>
                    <div id="result" >
                        <p className="stitle2" style={{"margin-top": "50px" , "margin-bottom": "50px", "text-align":"center"}}>
                            고객님이 건강 할 수 있도록 <span style={{"color": "#999"}}><br
                            className="mobile_br"/>이렇게 추천 합니다.</span>
                        </p>
                        <center>
                            {select2result.map((i, index) => (
                                <div key={index} >
                                <a  href="SearchBreadItem"  onClick={()=>searchDetail(i)}>
                                    <img src={i.breadImage} className={classes.size}/>
                                </a>
                                    <h3>{i.breadName}</h3>
                                </div>
                            ))}
                        </center>
                    </div>
                </div>
            </div>

        </>

    )


}