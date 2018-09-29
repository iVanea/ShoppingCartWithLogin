$(function(){
	$('#btn_add').click(addProduct);

	function addProduct(){
		alert(1);
		var productName = $('#product_name').val();
		var productPrice = $('#product_price').val();
		var url = "https://ss7.vzw.com/is/image/VerizonWireless/iPhoneX-Svr?$device-lg$";
		var product = {name:productName, price:productPrice, url:url};
		$.post('welcome',{product: JSON.stringify(product)}, processData, "json")
	}

	function processData(data){
		//data = JSON.parse(data);



		var td0=$('<td>').text(data.id);
		var td1 = $('<td>').text(data.name);
		var td2 = $('<td>').text(data.price);
		var td3 = $('<td>');
        var img = $("<img />").attr('src', data.url,
            'width',"50",'height',"50")
            .on('load', function() {
                if (!this.complete || typeof this.naturalWidth == "undefined" || this.naturalWidth == 0) {
                    alert('broken image!');
                } else {
                   td3.append(img);
                }
            });
		var tr = $('<tr>').append(td0).append(td1).append(td2).append(td3);
		$('#tbl_products>tbody').append(tr);
	}

function loadContent(){
		alert(1);
		var url = "https://my-json-server.typicode.com/iVanea/phones/db";
		$.get(url, onLoad(), json).error(function(){alert("error loading images");});
}

	function onLoad(data) {
var index =0;
        for (var phone in data) {
var ph = phone[index];

            var td1 = $('<td>').text(ph.title);
            var td2 = $('<td>').text(ph.price);
            var td3 = $('<td>');
            var img = $("<img />").attr('src', ph.img)
                .on('load', function () {
                    if (!this.complete || typeof this.naturalWidth == "undefined" || this.naturalWidth == 0) {
                        alert('broken image!');
                    } else {
                        img.addClass("tile");
                        td3.append(img);
                    }
                });
            var tr = $('<tr>').append(td1).append(td2).append(td3);
            $('#sell').append(tr);
        }
    }

    loadContent();
})

