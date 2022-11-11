/* globals Chart:false, feather:false */

(() => {
  'use strict'

  feather.replace({ 'aria-hidden': 'true' })
  // const Plugin = {};

  // Graphs
  const ctx = document.getElementById('myChart');
  // eslint-disable-next-line no-unused-vars
  const myChart = new Chart(ctx, {
    type: 'line',
    data: {
      labels: [
        '일',
        '월',
        '화',
        '수',
        '목',
        '금',
        '토'
      ],
      datasets: [{
        label: '환자수',
        data: [
          42,
          45,
          45,
          43,
          48,
          53,
          52
        ],
        lineTension: 0,
        backgroundColor: 'transparent',
        borderColor: '#905E96',
        borderWidth: 3,
        pointBackgroundColor: '#905E96'
      }]
    },
    options: {
      responsive: false,
      scales: {
        yAxes: [{
          stacked: false,
          ticks: {
            beginAtZero: false,
            max: 60,
            min: 30,
            padding: 5,
            stepSize: 5
          }
        }]
      },
      legend: {
        display: true
      }
    }
  })

  const ctx1 = document.getElementById('myChart2');
  // eslint-disable-next-line no-unused-vars
  const myChart2 = new Chart(ctx1, {
    type: 'pie',
    data: {
      labels: [
        '한방1과',
        '한방2과',
        '양방과'
      ],
      datasets: [{
        label: '# of Votes',
        data: [
          20,
          10,
          8
        ],
        backgroundColor: [
          '#905E96', '#D58BDD', '#FF99D7'
        ],
        lineTension: 0,
        borderColor: 'black',
        borderWidth: 1,
      }]
    },
    options: {
      responsive: false,
      // scales: {
      //   yAxes: [{
      //    ticks: {
      //      beginAtZero: false,
      //    }
      //  }]
      // },
      legend: {
        display: true
      }
    }
  })
})()

// var arr = ['11/02 14시 4층에서 전체 회의 있습니다.', '12/14 18시 송년회있습니다.'
//   , '11/05 19시 병동 회식있습니다.'];
  
//   document.getElementById('headline').innerText =arr[0]
//   let count = 1;
//   setInterval(()=>{
//   if(count<3){
//     document.getElementById('headline').innerText =arr[count++]
//   }else{
//     count=0;
//   }},3000);

  document.addEventListener('DOMContentLoaded', ()=>{
    var interval = window.setInterval(rollingCallback, 3000);
})
function rollingCallback(){
    //.prev 클래스 삭제
    document.querySelector('.rollingbanner .prev').classList.remove('prev');

    //.current -> .prev
    let current = document.querySelector('.rollingbanner .current');
    current.classList.remove('current');
    current.classList.add('prev');

    //.next -> .current
    let next = document.querySelector('.rollingbanner .next');
    //다음 목록 요소가 널인지 체크
    if(next.nextElementSibling == null){
        document.querySelector('.rollingbanner ul li:first-child').classList.add('next');
    }else{
        //목록 처음 요소를 다음 요소로 선택
        next.nextElementSibling.classList.add('next');
    }
    next.classList.remove('next');
    next.classList.add('current');
}