.class Lcom/delta/attendancetracker/CourseAttendance$2;
.super Ljava/lang/Object;
.source "CourseAttendance.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/delta/attendancetracker/CourseAttendance;->onCreate(Landroid/os/Bundle;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/delta/attendancetracker/CourseAttendance;


# direct methods
.method constructor <init>(Lcom/delta/attendancetracker/CourseAttendance;)V
    .locals 0
    .parameter

    .prologue
    .line 1
    iput-object p1, p0, Lcom/delta/attendancetracker/CourseAttendance$2;->this$0:Lcom/delta/attendancetracker/CourseAttendance;

    .line 139
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 6
    .parameter "arg0"

    .prologue
    .line 145
    iget-object v4, p0, Lcom/delta/attendancetracker/CourseAttendance$2;->this$0:Lcom/delta/attendancetracker/CourseAttendance;

    iget-object v4, v4, Lcom/delta/attendancetracker/CourseAttendance;->nClassesHeld:Landroid/widget/TextView;

    invoke-virtual {v4}, Landroid/widget/TextView;->getText()Ljava/lang/CharSequence;

    move-result-object v4

    invoke-interface {v4}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v1

    .line 146
    .local v1, hPlus:I
    add-int/lit8 v1, v1, 0x1

    .line 148
    new-instance v3, Ljava/lang/String;

    invoke-direct {v3}, Ljava/lang/String;-><init>()V

    .line 151
    .local v3, tot:Ljava/lang/String;
    :try_start_0
    iget-object v4, p0, Lcom/delta/attendancetracker/CourseAttendance$2;->this$0:Lcom/delta/attendancetracker/CourseAttendance;

    iget-object v4, v4, Lcom/delta/attendancetracker/CourseAttendance;->extra:Lorg/json/JSONObject;

    const-string v5, "total"

    invoke-virtual {v4, v5}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v3

    .line 157
    :goto_0
    invoke-static {v3}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v4

    int-to-float v2, v4

    .line 159
    .local v2, maxClasses:F
    int-to-float v4, v1

    cmpg-float v4, v4, v2

    if-gtz v4, :cond_0

    iget-object v4, p0, Lcom/delta/attendancetracker/CourseAttendance$2;->this$0:Lcom/delta/attendancetracker/CourseAttendance;

    iget-object v4, v4, Lcom/delta/attendancetracker/CourseAttendance;->nClassesHeld:Landroid/widget/TextView;

    invoke-static {v1}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 161
    :cond_0
    iget-object v4, p0, Lcom/delta/attendancetracker/CourseAttendance$2;->this$0:Lcom/delta/attendancetracker/CourseAttendance;

    invoke-virtual {v4}, Lcom/delta/attendancetracker/CourseAttendance;->update()V

    .line 163
    return-void

    .line 152
    .end local v2           #maxClasses:F
    :catch_0
    move-exception v0

    .line 154
    .local v0, e:Lorg/json/JSONException;
    invoke-virtual {v0}, Lorg/json/JSONException;->printStackTrace()V

    goto :goto_0
.end method
