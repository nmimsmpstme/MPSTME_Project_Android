.class Lcom/delta/attendancetracker/MainActivity$1;
.super Ljava/lang/Object;
.source "MainActivity.java"

# interfaces
.implements Landroid/widget/AdapterView$OnItemClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/delta/attendancetracker/MainActivity;->onResume()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Landroid/widget/AdapterView$OnItemClickListener;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/delta/attendancetracker/MainActivity;


# direct methods
.method constructor <init>(Lcom/delta/attendancetracker/MainActivity;)V
    .locals 0
    .parameter

    .prologue
    .line 1
    iput-object p1, p0, Lcom/delta/attendancetracker/MainActivity$1;->this$0:Lcom/delta/attendancetracker/MainActivity;

    .line 108
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onItemClick(Landroid/widget/AdapterView;Landroid/view/View;IJ)V
    .locals 5
    .parameter
    .parameter "view"
    .parameter "position"
    .parameter "id"
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/widget/AdapterView",
            "<*>;",
            "Landroid/view/View;",
            "IJ)V"
        }
    .end annotation

    .prologue
    .line 114
    .local p1, parent:Landroid/widget/AdapterView;,"Landroid/widget/AdapterView<*>;"
    const-string v2, "long clicked"

    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "pos: "

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3, p3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 116
    new-instance v1, Landroid/content/Intent;

    iget-object v2, p0, Lcom/delta/attendancetracker/MainActivity$1;->this$0:Lcom/delta/attendancetracker/MainActivity;

    const-class v3, Lcom/delta/attendancetracker/CourseAttendance;

    invoke-direct {v1, v2, v3}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 118
    .local v1, u:Landroid/content/Intent;
    :try_start_0
    const-string v2, "details"

    iget-object v3, p0, Lcom/delta/attendancetracker/MainActivity$1;->this$0:Lcom/delta/attendancetracker/MainActivity;

    iget-object v3, v3, Lcom/delta/attendancetracker/MainActivity;->cList:Lorg/json/JSONArray;

    invoke-virtual {v3, p3}, Lorg/json/JSONArray;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 119
    const-string v2, "position"

    invoke-virtual {v1, v2, p3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    .line 120
    sget-object v2, Ljava/lang/System;->out:Ljava/io/PrintStream;

    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "JSON SHARED : "

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v4, p0, Lcom/delta/attendancetracker/MainActivity$1;->this$0:Lcom/delta/attendancetracker/MainActivity;

    iget-object v4, v4, Lcom/delta/attendancetracker/MainActivity;->cList:Lorg/json/JSONArray;

    invoke-virtual {v4, p3}, Lorg/json/JSONArray;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 128
    :goto_0
    iget-object v2, p0, Lcom/delta/attendancetracker/MainActivity$1;->this$0:Lcom/delta/attendancetracker/MainActivity;

    invoke-virtual {v2, v1}, Lcom/delta/attendancetracker/MainActivity;->startActivity(Landroid/content/Intent;)V

    .line 130
    return-void

    .line 121
    :catch_0
    move-exception v0

    .line 123
    .local v0, e:Lorg/json/JSONException;
    invoke-virtual {v0}, Lorg/json/JSONException;->printStackTrace()V

    goto :goto_0
.end method
