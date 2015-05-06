.class Lcom/delta/attendancetracker/EditCourse$1;
.super Ljava/lang/Object;
.source "EditCourse.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/delta/attendancetracker/EditCourse;->onCreate(Landroid/os/Bundle;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/delta/attendancetracker/EditCourse;


# direct methods
.method constructor <init>(Lcom/delta/attendancetracker/EditCourse;)V
    .locals 0
    .parameter

    .prologue
    .line 1
    iput-object p1, p0, Lcom/delta/attendancetracker/EditCourse$1;->this$0:Lcom/delta/attendancetracker/EditCourse;

    .line 61
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 12
    .parameter "arg0"

    .prologue
    const/4 v7, 0x0

    .line 69
    iget-object v0, p0, Lcom/delta/attendancetracker/EditCourse$1;->this$0:Lcom/delta/attendancetracker/EditCourse;

    iget-object v0, v0, Lcom/delta/attendancetracker/EditCourse;->name:Landroid/widget/EditText;

    invoke-virtual {v0}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v0

    invoke-interface {v0}, Landroid/text/Editable;->toString()Ljava/lang/String;

    move-result-object v1

    .line 70
    .local v1, ename:Ljava/lang/String;
    iget-object v0, p0, Lcom/delta/attendancetracker/EditCourse$1;->this$0:Lcom/delta/attendancetracker/EditCourse;

    iget-object v0, v0, Lcom/delta/attendancetracker/EditCourse;->code:Landroid/widget/EditText;

    invoke-virtual {v0}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v0

    invoke-interface {v0}, Landroid/text/Editable;->toString()Ljava/lang/String;

    move-result-object v2

    .line 71
    .local v2, eid:Ljava/lang/String;
    iget-object v0, p0, Lcom/delta/attendancetracker/EditCourse$1;->this$0:Lcom/delta/attendancetracker/EditCourse;

    iget-object v0, v0, Lcom/delta/attendancetracker/EditCourse;->total:Landroid/widget/EditText;

    invoke-virtual {v0}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v0

    invoke-interface {v0}, Landroid/text/Editable;->toString()Ljava/lang/String;

    move-result-object v3

    .line 72
    .local v3, etotal:Ljava/lang/String;
    iget-object v0, p0, Lcom/delta/attendancetracker/EditCourse$1;->this$0:Lcom/delta/attendancetracker/EditCourse;

    iget-object v0, v0, Lcom/delta/attendancetracker/EditCourse;->required:Landroid/widget/EditText;

    invoke-virtual {v0}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v0

    invoke-interface {v0}, Landroid/text/Editable;->toString()Ljava/lang/String;

    move-result-object v4

    .line 74
    .local v4, erequired:Ljava/lang/String;
    const/4 v9, 0x0

    .line 75
    .local v9, b:I
    invoke-static {v3}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v8

    .line 77
    .local v8, a:I
    :try_start_0
    iget-object v0, p0, Lcom/delta/attendancetracker/EditCourse$1;->this$0:Lcom/delta/attendancetracker/EditCourse;

    iget-object v0, v0, Lcom/delta/attendancetracker/EditCourse;->details:Lorg/json/JSONObject;

    const-string v6, "classesMissed"

    invoke-virtual {v0, v6}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I
    :try_end_0
    .catch Ljava/lang/NumberFormatException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_1

    move-result v9

    .line 86
    :goto_0
    iget-object v0, p0, Lcom/delta/attendancetracker/EditCourse$1;->this$0:Lcom/delta/attendancetracker/EditCourse;

    iget-object v0, v0, Lcom/delta/attendancetracker/EditCourse;->rg:Landroid/widget/RadioGroup;

    invoke-virtual {v0}, Landroid/widget/RadioGroup;->getCheckedRadioButtonId()I

    move-result v5

    .line 87
    .local v5, radioButtonID:I
    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v0

    if-eqz v0, :cond_0

    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v0

    if-eqz v0, :cond_0

    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v0

    if-eqz v0, :cond_0

    invoke-virtual {v4}, Ljava/lang/String;->length()I

    move-result v0

    if-nez v0, :cond_1

    .line 89
    :cond_0
    iget-object v0, p0, Lcom/delta/attendancetracker/EditCourse$1;->this$0:Lcom/delta/attendancetracker/EditCourse;

    const-string v6, "Please fill all fields!"

    invoke-static {v0, v6, v7}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/Toast;->show()V

    .line 109
    :goto_1
    return-void

    .line 78
    .end local v5           #radioButtonID:I
    :catch_0
    move-exception v11

    .line 80
    .local v11, e1:Ljava/lang/NumberFormatException;
    invoke-virtual {v11}, Ljava/lang/NumberFormatException;->printStackTrace()V

    goto :goto_0

    .line 81
    .end local v11           #e1:Ljava/lang/NumberFormatException;
    :catch_1
    move-exception v11

    .line 83
    .local v11, e1:Lorg/json/JSONException;
    invoke-virtual {v11}, Lorg/json/JSONException;->printStackTrace()V

    goto :goto_0

    .line 91
    .end local v11           #e1:Lorg/json/JSONException;
    .restart local v5       #radioButtonID:I
    :cond_1
    if-ge v8, v9, :cond_2

    .line 93
    iget-object v0, p0, Lcom/delta/attendancetracker/EditCourse$1;->this$0:Lcom/delta/attendancetracker/EditCourse;

    const-string v6, "Classes missed cannot be higher than total classes!"

    invoke-static {v0, v6, v7}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/Toast;->show()V

    goto :goto_1

    .line 95
    :cond_2
    invoke-static {v4}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v0

    const/16 v6, 0x64

    if-le v0, v6, :cond_3

    .line 97
    iget-object v0, p0, Lcom/delta/attendancetracker/EditCourse$1;->this$0:Lcom/delta/attendancetracker/EditCourse;

    const-string v6, "Required % cannot be greater than 100!"

    invoke-static {v0, v6, v7}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/Toast;->show()V

    goto :goto_1

    .line 102
    :cond_3
    :try_start_1
    iget-object v0, p0, Lcom/delta/attendancetracker/EditCourse$1;->this$0:Lcom/delta/attendancetracker/EditCourse;

    iget-object v6, p0, Lcom/delta/attendancetracker/EditCourse$1;->this$0:Lcom/delta/attendancetracker/EditCourse;

    iget-object v6, v6, Lcom/delta/attendancetracker/EditCourse;->details:Lorg/json/JSONObject;

    const-string v7, "name"

    invoke-virtual {v6, v7}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    iget-object v7, p0, Lcom/delta/attendancetracker/EditCourse$1;->this$0:Lcom/delta/attendancetracker/EditCourse;

    iget-object v7, v7, Lcom/delta/attendancetracker/EditCourse;->datesMissed:Lorg/json/JSONArray;

    invoke-virtual/range {v0 .. v7}, Lcom/delta/attendancetracker/EditCourse;->editCourse(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Lorg/json/JSONArray;)V
    :try_end_1
    .catch Lorg/json/JSONException; {:try_start_1 .. :try_end_1} :catch_2

    goto :goto_1

    .line 103
    :catch_2
    move-exception v10

    .line 105
    .local v10, e:Lorg/json/JSONException;
    invoke-virtual {v10}, Lorg/json/JSONException;->printStackTrace()V

    goto :goto_1
.end method
