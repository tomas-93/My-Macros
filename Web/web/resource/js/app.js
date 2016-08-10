/**
 * Created by Tomas on 24/07/2016.
 */
function card()
{
    $("#mCard").css("display", "block");
    $("#mdl-button").click(function () {
        $("#mCard").css("display", "none");

    });

}

function rage(id)
{
    console.log(id);
    if(id == "rageCarb")
    {
        $(".totalCarbohydrates").val($("#rageCarb").val());

    }

    if(id == "rageFiber")
    {
        $(".fiber").val($("#rageFiber").val());
    }

    if(id == "rageProte")
    {
        $(".totalProtein").val($("#rageProte").val());
    }

    if(id == "rageCal")
    {
        $(".totalCal").val($("#rageCal").val());
    }

    if(id == "rageFat")
    {
        $(".totalFats").val($("#rageFat").val());
    }
}

function sw()
{
    if ($("#switch1").val() == "on")
    {
        $(".x").css("display","none");
        $(".polyunsaturated").val(0);
        $(".monounsaturated").val(0);
        $(".saturated").val(0);
        $(".sugar").val(0);
        $("#switch1").val("off");
    }
    else
    {
        $(".x").css("display","inline-block");
        $(".polyunsaturated").val("");
        $(".monounsaturated").val("");
        $(".saturated").val("");
        $(".sugar").val("");
        $("#switch1").val("on");
    }

}