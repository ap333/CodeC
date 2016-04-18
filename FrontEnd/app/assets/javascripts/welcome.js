var start = function(){
  $('.artlist').show();
  $(".vidlist").hide();
  $('#articles').css({"background":"#D31D1B", "color":"white"});
  $('#videos').css({"background":"white", "color":"#D31D1B"});
  remove10();
};

var showVideos = function(){
  $('#videos').click(function(){
    $(".vidlist").show();
    $(".artlist").hide();
    $('#videos').css({"background":"#D31D1B", "color":"white"});
    $('#articles').css({"background":"white", "color":"#D31D1B"});
    remove10();
  });
};

var showArticles = function(){
  $('#articles').click(function(){
    $(".artlist").show();
    $(".vidlist").hide();
    $('#articles').css({"background":"#D31D1B", "color":"white"});
    $('#videos').css({"background":"white", "color":"#D31D1B"});
    remove10();
  });
};

var remove10 = function(){
  $('.aa').slice(-10).hide();
  $('.vv').slice(-10).hide();
  $('.more').show();
};

var showMore = function(){
  $('.more').click(function(){
    $('.more').hide();
    $('.aa').slice(-10).show();
    $('.vv').slice(-10).show();
  });
};

var fixTime = function(){
  for (i = 0; i < $(".vidTime").length; i++){
    var temp = $(".vidTime")[i]
    if (temp.innerHTML < 60){
      temp.innerHTML = "0:" + temp.innerHTML
    }
    else if (temp.innerHTML % 60 < 10) {
      temp.innerHTML = Math.floor(temp.innerHTML/60) + ":0" +temp.innerHTML % 60
    }
    else {
      temp.innerHTML = Math.floor(temp.innerHTML/60) + ":" + temp.innerHTML % 60
    }
  }
}

var fixDate = function(){
  var months = {"01":"Jan","02":"Feb","03":"Mar","04":"Apr","05":"May","06":"Jun","07":"Jul","08":"Aug","09":"Sep","10":"Oct","11":"Nov","12":"Dec"};
  for (i = 0; i < $(".aDate").length; i++){
    var temp = $(".aDate")[i]
    temp.innerHTML = temp.innerHTML.slice(11,16) + " " + temp.innerHTML.slice(8,10) + " " + months[temp.innerHTML.slice(5,7)];
  }
};

var fixIndex = function(){
  for (i = 0; i < $(".row").length; i++){
    var temp = $(".row")[i];
    if (temp.innerHTML < 10){
      temp.innerHTML = "0" + temp.innerHTML;
    }
  }
}

var hoverImage = function(){
  $(".sub").on("mouseenter",function(){
    var img = $(this)[0].children[0].innerHTML
    $("#"+$(this)[0].id).css({"background-image": 'url(' + img + ')',"color": "white"});
  });
  $(".sub").on("mouseleave",function(){
    $("#"+$(this)[0].id).css({"background-image": 'none', "color": "black"})
  });
}

$(document).ready(function(){
  start();
  showVideos();
  showArticles();
  showMore();
  fixTime();
  fixDate();
  fixIndex();
  hoverImage();
});
