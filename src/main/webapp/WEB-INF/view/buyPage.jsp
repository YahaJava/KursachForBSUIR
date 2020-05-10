<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<tags:master pageTitle="Купить билет ${movie.name}">
    <script>
        function mark(element) {
            let times = document.getElementsByClassName('time');
            for (let i = 0; i < times.length; i++) {
                times[i].style = '';
            }
            element.style = 'background: red;';
            let button = document.getElementById('next-button1');
            button.removeAttribute('disabled');
        }

        function next1() {
            let dates = document.getElementsByClassName('date-container');
            let choisenTime, choisenDate;
            for (let i = 0; i < dates.length; i++) {
                let find = false;
                let times = dates[i].getElementsByClassName('time');
                for (let j = 0; j < times.length; j++) {
                    if (times[j].style.getPropertyValue('background') === 'red') {
                        choisenTime = times[j].innerText;
                        find = true;
                        break;
                    }
                }
                if (find === true) {
                    choisenDate = dates[i].getElementsByClassName('date')[0].innerText;
                    break;
                }
            }
            document.getElementById('choisenTime').setAttribute('value', choisenTime);
            document.getElementById('choisenDate').setAttribute('value', choisenDate);
            document.getElementById('submit-date1').submit();

        }

        var selected = 0;

        var resultSeats = '';

        function chooseSeat(seat, row, column) {
            if (seat.style.getPropertyValue("color") === 'red') {
                seat.style = '';
                selected--;
                removeSeat(row, column);
            } else {
                seat.style = 'color:red; background-image: url("../../resources/images/choosen-seat.png");';
                selected++;
                addSeat(row, column);
            }
            swap();
        }

        function addSeat(row, column) {
            resultSeats += row + ':' + column + ' ';
        }

        function removeSeat(row, column) {
            let str = resultSeats.split(' ');
            resultSeats = '';
            for (let i = 0; i < str.length - 1; i++) {
                if (str[i] !== (row + ":" + column)) {
                    resultSeats += str[i] + ' ';
                }
            }
        }

        function sortSeats() {
            let seats = resultSeats.split(' ');
            seats.sort();
            resultSeats='';
            for (let i=1;i<seats.length;i++) {
                resultSeats+=seats[i] + " ";
            }
            resultSeats = resultSeats.substring(0, resultSeats.length - 1);
        }

        function swap() {
            const button = document.getElementById('next-button2');
            const sel = document.getElementById("amount");
            const selText = sel.options[sel.selectedIndex].text;
            if (selText == selected) {
                button.removeAttribute('disabled');
            } else {
                button.setAttribute('disabled', 'disabled');
            }

        }

        function next2() {
            sortSeats();
            document.getElementById('choisenSeats').setAttribute('value', resultSeats);
            document.getElementById('submit-date2').submit();
        }
    </script>
    <div class="buy-ticket-container">
        <img src="${movie.posterURL}" height="250px">
        <div class="buy-ticket-info-container">
            <div style="display: flex; justify-content: space-between; flex-direction: column; height: 260px">
                <div>
                    <p class="buy-ticket">Купить билет на фильм ${movie.name}</p>
                    <p class="price">Стоимость: 12.49 руб</p>

                    <c:if test="${type =='seats'|| type=='result'}">
                        <p class="buy-ticket-selected-info">Дата: ${param.choisenDate}</p>
                        <p class="buy-ticket-selected-info">Время: ${param.choisenTime}</p>
                    </c:if>
                    <c:if test="${type=='result'}">
                        <p class="buy-ticket-selected-info">Места: ${param.choisenSeats}</p>
                    </c:if>
                </div>

                <c:if test="${type =='date'}">
                    <form id="submit-date1" action="${pageContext.request.contextPath}/buy/seat/${movie.id}">
                        <input type="hidden" name="choisenTime" id="choisenTime">
                        <input type="hidden" name="choisenDate" id="choisenDate">
                        <button id="next-button1" onclick="next1()" class="w-25 btn btn-success" disabled>
                            Далее
                        </button>
                    </form>
                </c:if>
                <c:if test="${type =='seats'}">
                    <form id="submit-date2" action="${pageContext.request.contextPath}/buy/result/${movie.id}">
                        <input type="hidden" name="choisenTime" value="${param.choisenTime}">
                        <input type="hidden" name="choisenDate" value="${param.choisenDate}">
                        <input type="hidden" name="choisenSeats" id="choisenSeats" >
                        <button id="next-button2" onclick="next2()" class="w-25 btn btn-success" disabled>
                            Далее
                        </button>
                    </form>
                </c:if>
                <c:if test="${type =='result'}">
                    <form id="submit-date3" action="${pageContext.request.contextPath}/buy/confirm/${movie.id}">
                        <input type="hidden" name="choisenTime" value="${param.choisenTime}">
                        <input type="hidden" name="choisenDate" value="${param.choisenDate}">
                        <input type="hidden" name="choisenSeats" value="${param.choisenSeats}">
                        <button id="next-button3" class="w-25 btn btn-success">
                            Подтведить
                        </button>
                    </form>
                </c:if>


            </div>
        </div>
    </div>
    <hr>
    <c:if test="${type=='date'}">
        <p class="choose">Выберите дату и время сеанса:</p>
        <div class="full-date-container">
            <c:forEach var="item" items="${schedule}">
                <div class="date-container">
                    <div class="date">${item.date}</div>
                    <div class="time-container">
                        <c:forEach var="time" items="${item.times}">
                            <div class="time" onclick="mark(this)">${time}</div>
                        </c:forEach>
                    </div>
                </div>
            </c:forEach>
        </div>
    </c:if>
    <c:if test="${type=='seats'}">
        <p class="choose">Выберите места:</p>
        <div style="display: flex;">
            <div class="form-group col-md-2">
                <label for="amount">Кол-во мест:</label>
                <select id="amount" style = "height: 30px" onchange="swap()" class="form-control">
                    <option selected>1</option>
                    <option>2</option>
                    <option>3</option>
                    <option>4</option>
                    <option>5</option>
                    <option>6</option>
                    <option>7</option>
                    <option>8</option>
                </select>
            </div>
            <div style="display: flex; flex-direction: column">
                <c:forEach var="row" begin="1" end="5">
                    <div style="display: flex;">
                        <c:forEach var="column" begin="1" end="15">
                            <c:set var="taken" value="false"/>
                            <c:forEach var="takenSeat" items="${takenSeats}">
                                <c:if test="${takenSeat.row == row && takenSeat.column == column}">
                                    <div class="seat-invalid"></div>
                                    <c:set var="taken" value="true"/>
                                </c:if>
                            </c:forEach>
                            <c:if test="${!taken}">
                                <div class="seat" onclick="chooseSeat(this,${row},${column})"></div>
                            </c:if>
                        </c:forEach>
                    </div>
                </c:forEach>
            </div>
            <div>
                <img style="margin-left: 30px" src="../../resources/images/seat.png"/> Свободно
                <img style="margin-left: 10px" src="../../resources/images/choosen-seat.png"/> Выбрано
                <img style="margin-left: 10px" src="../../resources/images/invalid-seat.png"/> Занято
            </div>
        </div>
    </c:if>
    <c:if test="${type=='result'}">
        <p class="choose">Подтвердите выбранные данные</p>
    </c:if>
    <c:if test="${type=='empty'}">
        <p class="choose">На данный момент сеансов нет</p>
    </c:if>

</tags:master>