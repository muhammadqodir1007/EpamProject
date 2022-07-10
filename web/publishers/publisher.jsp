<%--
  Created by IntelliJ IDEA.
  User: Temurbek
  Date: 7/10/2022
  Time: 7:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
    body{
        background:#eee;
    }


    .fonts{
        font-size:11px;
    }

    .social-list{
        display:flex;
        list-style:none;
        justify-content:center;
        padding:0;
    }

    .social-list li{
        padding:10px;
        color:#8E24AA;
        font-size:19px;
    }


    .buttons button:nth-child(1){
        border:1px solid #8E24AA !important;
        color:#8E24AA;
        height:40px;
    }

    .buttons button:nth-child(1):hover{
        border:1px solid #8E24AA !important;
        color:#fff;
        height:40px;
        background-color:#8E24AA;
    }

    .buttons button:nth-child(2){
        border:1px solid #8E24AA !important;
        background-color:#8E24AA;
        color:#fff;
        height:40px;
    }
</style>
<div class="container mt-5">

    <div class="row d-flex justify-content-center">

        <div class="col-md-7">

            <div class="card p-3 py-4">

                <div class="text-center">
                    <img src="https://i.imgur.com/bDLhJiP.jpg" width="100" class="rounded-circle">
                </div>

                <div class="text-center mt-3">
                    <span class="bg-secondary p-1 px-4 rounded text-white">Pro</span>
                    <h5 class="mt-2 mb-0">Alexender Schidmt</h5>
                    <span>UI/UX Designer</span>

                    <div class="px-4 mt-1">
                        <p class="fonts">Consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. </p>

                    </div>

                    <ul class="social-list">
                        <li><i class="fa fa-facebook"></i></li>
                        <li><i class="fa fa-dribbble"></i></li>
                        <li><i class="fa fa-instagram"></i></li>
                        <li><i class="fa fa-linkedin"></i></li>
                        <li><i class="fa fa-google"></i></li>
                    </ul>

                    <div class="buttons">

                        <button class="btn btn-outline-primary px-4">Message</button>
                        <button class="btn btn-primary px-4 ms-3">Contact</button>
                    </div>


                </div>




            </div>

        </div>

    </div>

</div>