/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/ClientSide/javascript.js to edit this template
 */


function loadBinhLuan(endpoint) {
    fetch(endpoint).then(function (res) {
        return res.json();
    }).then(function (data) {
        let bl = document.getElementById("bl");
        let h = '';
        for (let d of data)
            h += `   
                <div style="background-color: grey; margin: 10px; padding: 2px">
                    <div class="coment-bottom bg-white p-2 px-4">
                        <div class="d-flex flex-row comment-user"><img class="rounded-circle" src="https://res.cloudinary.com/dxs9d8uua/image/upload/v1661453159/urh0kmsgkxktheudu9m3.jpg" width="40">
                            <div class="ml-2">
                                <div class="d-flex flex-row align-items-center"><span class="name font-weight-bold">${d.taiKhoan.taiKhoan}</span>
                                    <span class="dot"></span>
                                    <span class="my-date">${moment(d.ngayBinhLuan).locale("vi").fromNow()}</span>
                                </div>
                            </div>
                        </div>
                        <div class="mt-2">
                            <p class="comment-text">${d.binhLuan}</p>
                        </div>
                    </div>
                </div>`;
        bl.innerHTML = h;
    });
}

function addBinhLuan(endpoint, ntdID) {
    fetch(endpoint, {
        method: "post",
        body: JSON.stringify({
            "binhLuan": document.getElementById("binhLuan").value,
            "maNTD": ntdID
        }),
        headers: {
            "Content-Type": "application/json"
        }
    }).then(function (res) {
        return res.json();
    }).then(function (data) {
        let d = document.querySelector("#bl div:first-child");
        let h = `   
                <div style="background-color: grey; margin: 10px; padding: 2px">
                    <div class="coment-bottom bg-white p-2 px-4">
                        <div class="d-flex flex-row comment-user"><img class="rounded-circle" src="https://res.cloudinary.com/dxs9d8uua/image/upload/v1661453159/urh0kmsgkxktheudu9m3.jpg" width="40">
                            <div class="ml-2">
                                <div class="d-flex flex-row align-items-center"><span class="name font-weight-bold">${data.taiKhoan.taiKhoan}</span>
                                    <span class="dot"></span>
                                    <span class="my-date">${moment(data.ngayBinhLuan).locale("vi").fromNow()}</span>
                                </div>
                            </div>
                        </div>
                        <div class="mt-2">
                            <p class="comment-text">${data.binhLuan}</p>
                        </div>
                    </div>
                </div>
                `;

        d.insertAdjacentHTML("beforebegin", h);
    });
}
//
//function addUngTuyen(endpoint, jobID) {
//    fetch(endpoint, {
//        method: "post",
//        body: JSON.stringify({
//            "thuGT": document.getElementById("thuGT").value,
//            "tin": jobID
//        }),
//        headers: {
//            "Content-Type": "application/json"
//        }
//    }).then(function (res) {
//        return res.json();
//    });
//}
